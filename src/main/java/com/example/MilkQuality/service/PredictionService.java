package com.example.MilkQuality.service;

import com.example.MilkQuality.dto.MilkSampleRequest;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PredictionService {

    private Evaluator evaluator;

    @PostConstruct
    public void init() {
        // Carregar o modelo PMML do classpath
        ClassPathResource resource = new ClassPathResource("modelo/modelo_leite_random_forest.pmml");

        try (InputStream inputStream = resource.getInputStream()) {
            PMML pmml = org.jpmml.model.PMMLUtil.unmarshal(inputStream);

            // Criar o evaluator
            ModelEvaluatorBuilder evaluatorBuilder = new ModelEvaluatorBuilder(pmml);
            this.evaluator = evaluatorBuilder.build();

            // Verificar o evaluator
            this.evaluator.verify();

            System.out.println("Modelo PMML carregado com sucesso!");
            System.out.println("Campos de entrada: " + evaluator.getInputFields());
            System.out.println("Campos de saída: " + evaluator.getTargetFields());
        } catch (Exception e) {
            System.err.println("Erro ao carregar modelo PMML: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar modelo PMML", e);
        }
    }

    public String predict(MilkSampleRequest request) {
        try {
            // Preparar os dados de entrada
            Map<String, Object> arguments = new LinkedHashMap<>();

            System.out.println("\n=== PREDIÇÃO ===");

            // Aqui os nomes precisam ser IGUAIS aos nomes do PMML
            arguments.put("pH", request.getpH());
            arguments.put("Temperatura", request.getTemperatura());
            arguments.put("Gosto", request.getGosto());
            arguments.put("Odor", request.getOdor());
            arguments.put("Gordura", request.getGordura());
            arguments.put("Turbidez", request.getTurbidez());
            arguments.put("Cor", request.getCor());

            System.out.println("Argumentos: " + arguments);

            // Executar o modelo
            Map<String, ?> results = evaluator.evaluate(arguments);

            System.out.println("Resultado bruto do modelo: " + results);

            // Descobrir o campo target automaticamente
            String targetField = evaluator.getTargetFields().get(0).getName().toString();
            System.out.println("Campo alvo (target): " + targetField);

            Object rawPrediction = results.get(targetField);

            String prediction;

            if (rawPrediction instanceof Computable) {
                prediction = ((Computable) rawPrediction).getResult().toString();
            } else {
                prediction = rawPrediction.toString();
            }

            prediction = prediction.toLowerCase().trim();

            System.out.println("Predição FINAL (corrigida): " + prediction);
            System.out.println("=============================\n");

            return prediction;

        } catch (Exception e) {
            System.err.println("Erro ao fazer predição: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar predição: " + e.getMessage(), e);
        }
    }

    public String getDescricao(String nota) {
        switch (nota.toLowerCase()) {
            case "high":
                return "Leite de alta qualidade, próprio para consumo.";
            case "medium":
                return "Leite de qualidade média, requer atenção.";
            case "low":
                return "Leite de baixa qualidade, não recomendado para consumo.";
            default:
                return "Qualidade desconhecida.";
        }
    }
}
