# Exemplos de Requisições para Teste

## Exemplo 1 - Alta Qualidade
```json
{
  "pH": 6.6,
  "temperatura": 40,
  "gosto": 1,
  "odor": 1,
  "gordura": 1,
  "turbidez": 0,
  "cor": 255
}
```

## Exemplo 2 - Qualidade Média
```json
{
  "pH": 6.8,
  "temperatura": 55,
  "gosto": 1,
  "odor": 0,
  "gordura": 0,
  "turbidez": 1,
  "cor": 245
}
```

## Exemplo 3 - Baixa Qualidade
```json
{
  "pH": 8.5,
  "temperatura": 85,
  "gosto": 0,
  "odor": 0,
  "gordura": 0,
  "turbidez": 1,
  "cor": 240
}
```

## Testando com cURL

### Alta Qualidade
```bash
curl -X POST http://localhost:8080/api/predicao \
  -H "Content-Type: application/json" \
  -d "{\"pH\":6.6,\"temperatura\":40,\"gosto\":1,\"odor\":1,\"gordura\":1,\"turbidez\":0,\"cor\":255}"
```

### Qualidade Média
```bash
curl -X POST http://localhost:8080/api/predicao \
  -H "Content-Type: application/json" \
  -d "{\"pH\":6.8,\"temperatura\":55,\"gosto\":1,\"odor\":0,\"gordura\":0,\"turbidez\":1,\"cor\":245}"
```

### Baixa Qualidade
```bash
curl -X POST http://localhost:8080/api/predicao \
  -H "Content-Type: application/json" \
  -d "{\"pH\":8.5,\"temperatura\":85,\"gosto\":0,\"odor\":0,\"gordura\":0,\"turbidez\":1,\"cor\":240}"
```

## Testando com PowerShell

### Alta Qualidade
```powershell
$body = @{
    pH = 6.6
    temperatura = 40
    gosto = 1
    odor = 1
    gordura = 1
    turbidez = 0
    cor = 255
} | ConvertTo-Json

Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/predicao" -Body $body -ContentType "application/json"
```

### Qualidade Média
```powershell
$body = @{
    pH = 6.8
    temperatura = 55
    gosto = 1
    odor = 0
    gordura = 0
    turbidez = 1
    cor = 245
} | ConvertTo-Json

Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/predicao" -Body $body -ContentType "application/json"
```

### Baixa Qualidade
```powershell
$body = @{
    pH = 8.5
    temperatura = 85
    gosto = 0
    odor = 0
    gordura = 0
    turbidez = 1
    cor = 240
} | ConvertTo-Json

Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/predicao" -Body $body -ContentType "application/json"
```

## Resposta Esperada

```json
{
  "nota": "high",
  "descricao": "Leite de alta qualidade, próprio para consumo.",
  "sucesso": true
}
```

ou

```json
{
  "nota": "medium",
  "descricao": "Leite de qualidade média, requer atenção.",
  "sucesso": true
}
```

ou

```json
{
  "nota": "low",
  "descricao": "Leite de baixa qualidade, não recomendado para consumo.",
  "sucesso": true
}
```
