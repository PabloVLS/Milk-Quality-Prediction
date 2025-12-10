import requests
import json
import time

# URL do servidor
url = "http://localhost:8081/api/predicao"

# Teste 1: Qualidade alta esperada
teste1 = {
    "pH": 6.6,
    "temperatura": 40,
    "gosto": 1,
    "odor": 1,
    "gordura": 1,
    "turbidez": 0,
    "cor": 252
}

# Teste 2: Qualidade baixa esperada
teste2 = {
    "pH": 3.5,
    "temperatura": 25,
    "gosto": 0,
    "odor": 0,
    "gordura": 0,
    "turbidez": 1,
    "cor": 0
}

print("=" * 60)
print("TESTE DE PREDIÇÃO - MILK QUALITY")
print("=" * 60)
print()

for i, teste in enumerate([teste1, teste2], 1):
    print(f"Teste {i}: {teste}")
    print("-" * 60)
    
    try:
        response = requests.post(url, json=teste, timeout=5)
        print(f"Status Code: {response.status_code}")
        print(f"Response: {json.dumps(response.json(), indent=2, ensure_ascii=False)}")
    except Exception as e:
        print(f"Erro: {e}")
    
    print()
    print()
