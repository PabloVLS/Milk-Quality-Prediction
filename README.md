# Sistema de Análise de Qualidade de Leite

Sistema web para classificação de qualidade de leite utilizando Machine Learning (Random Forest) através de modelo PMML.

## 🚀 Tecnologias

- **Backend**: Spring Boot 3.3.5 + Java 21
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Machine Learning**: Modelo Random Forest (PMML) treinado no KNIME
- **Biblioteca PMML**: JPMML Evaluator 1.6.5

## 📋 Funcionalidades

- Análise de qualidade de leite com base em 7 parâmetros:
  - pH (3.0 - 9.5)
  - Temperatura (34°C - 90°C)
  - Gosto (0 = Ruim, 1 = Bom)
  - Odor (0 = Ruim, 1 = Bom)
  - Gordura (0 = Baixa, 1 = Alta)
  - Turbidez (0 = Baixa, 1 = Alta)
  - Cor (240 - 255)

- Classificação em 3 níveis de qualidade:
  - **HIGH** (Alta qualidade)
  - **MEDIUM** (Qualidade média)
  - **LOW** (Baixa qualidade)

## 🔧 Pré-requisitos

- Java 21+ (JDK)
- Maven 3.6+
- Navegador Web moderno

## 📦 Instalação e Execução

### 1. Clone o repositório (se aplicável)
```bash
cd MilkQuality
```

### 2. Compile o projeto com Maven
```bash
mvnw clean install
```

### 3. Execute a aplicação
```bash
mvnw spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8081**

## 📡 Endpoints da API

### GET `/api/status`
Verifica o status da API.

**Resposta:**
```
API de predição de qualidade de leite está funcionando!
```

### POST `/api/predicao`
Realiza a predição da qualidade do leite.

**Request Body:**
```json
{
  "pH": 6.6,
  "temperatura": 40,
  "gosto": 1,
  "odor": 1,
  "gordura": 1,
  "turbidez": 0,
  "cor": 250
}
```

**Response:**
```json
{
  "nota": "high",
  "descricao": "Leite de alta qualidade, próprio para consumo.",
  "sucesso": true
}
```

**URL Base:** http://localhost:8081

## 🎯 Como Usar

1. Acesse **http://localhost:8081** no navegador
2. Preencha todos os campos do formulário com as características da amostra de leite
3. Clique em "Analisar Qualidade"
4. O resultado será exibido no painel à direita com:
   - Classificação da qualidade
   - Descrição detalhada
   - Gráfico radar com os parâmetros
   - Indicadores visuais

## 📁 Estrutura do Projeto

```
MilkQuality/
├── src/
│   ├── main/
│   │   ├── java/com/example/MilkQuality/
│   │   │   ├── MilkQualityApplication.java
│   │   │   ├── controller/
│   │   │   │   └── PredictionController.java
│   │   │   ├── service/
│   │   │   │   └── PredictionService.java
│   │   │   └── dto/
│   │   │       ├── MilkSampleRequest.java
│   │   │       └── MilkPredictionResponse.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── modelo/
│   │       │   └── modelo_leite_random_forest.pmml
│   │       └── templates/
│   │           └── index.html
│   └── test/
├── pom.xml
└── README.md
```

## 🔍 Detalhes Técnicos

### Modelo PMML
O modelo Random Forest foi treinado no KNIME e exportado em formato PMML (Predictive Model Markup Language). O arquivo está localizado em `src/main/resources/modelo/modelo_leite_random_forest.pmml`.

### Backend (Spring Boot)
- **PredictionService**: Carrega o modelo PMML na inicialização e processa as predições
- **PredictionController**: Expõe endpoints REST para comunicação com o frontend
- **DTOs**: Classes para serialização/deserialização de dados (Request/Response)

### Frontend
- Interface responsiva com design moderno
- Validação de formulário em tempo real
- Visualização de resultados com gráfico radar (Chart.js)
- Explicações detalhadas sobre cada parâmetro

## 🐛 Troubleshooting

### Erro: "Modelo PMML não encontrado"
Verifique se o arquivo `modelo_leite_random_forest.pmml` está em `src/main/resources/modelo/`

### Erro: "Connection refused"
Certifique-se de que o backend está rodando na porta 8080:
```bash
mvnw spring-boot:run
```

### Erro ao compilar
Limpe o cache do Maven e recompile:
```bash
mvnw clean install -U
```

## 📝 Notas

- O modelo aceita valores dentro dos intervalos especificados no PMML
- A API possui CORS habilitado para aceitar requisições de qualquer origem
- Logs detalhados estão disponíveis no console durante a execução

## 👥 Autores

Desenvolvido para o projeto de Inteligência de Negócios.

---

**Porta padrão**: 8081  
**Acesso web**: http://localhost:8081
