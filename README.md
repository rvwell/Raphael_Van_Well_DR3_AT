# DR3 AT

Aplicação de microserviços composta por: **product-service**, **discount-service** e **shop-service**.

## Pré-requisitos

- Docker e Docker Compose (para execução com Docker)
- Kubernetes e kubectl (para execução com Kubernetes)
- Maven (para build local)

## Executando com Docker

### Subir todos os containers

```bash
docker-compose up -d --build
```

**Endpoints:**

- Shop Service: http://localhost:8080
- Product Service: http://localhost:8081
- Discount Service: http://localhost:8082

## Executando com Kubernetes

### 4. Deploy dos microserviços

```bash
kubectl apply -f .
```

### 5. Verificar status

```bash
kubectl get pods -n dr3-at
kubectl get services -n dr3-at
```

### Remover tudo

```bash
kubectl delete all --all -n dr3-at
```
