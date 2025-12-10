package com.example.MilkQuality.controller;

import com.example.MilkQuality.dto.MilkPredictionResponse;
import com.example.MilkQuality.dto.MilkSampleRequest;
import com.example.MilkQuality.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/predicao")
    public ResponseEntity<MilkPredictionResponse> predict(@RequestBody MilkSampleRequest request) {
        try {
            System.out.println("Recebida requisição de predição: " + request);
            
            // Fazer a predição usando o serviço
            String nota = predictionService.predict(request);
            String descricao = predictionService.getDescricao(nota);
            
            // Criar resposta
            MilkPredictionResponse response = new MilkPredictionResponse(nota, descricao, true);
            
            System.out.println("Resposta da predição: " + response);
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            System.err.println("Erro no controller: " + e.getMessage());
            e.printStackTrace();
            
            MilkPredictionResponse errorResponse = new MilkPredictionResponse(
                null, 
                "Erro ao processar a predição: " + e.getMessage(), 
                false
            );
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("API de predição de qualidade de leite está funcionando!");
    }
}
