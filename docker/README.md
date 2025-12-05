# Docker Setup

Este diretório contém os arquivos Docker para executar todos os microserviços.

## Estrutura

- `Dockerfile.product` - Dockerfile para o microserviço product
- `Dockerfile.discount` - Dockerfile para o microserviço discount
- `Dockerfile.shop` - Dockerfile para o microserviço shop
- `docker-compose.yml` - Orquestração de todos os serviços

## Como executar

### Pré-requisitos
- Docker
- Docker Compose

### Comandos

Para subir todos os serviços:
```bash
docker-compose up -d
```

Para ver os logs:
```bash
docker-compose logs -f
```

Para parar todos os serviços:
```bash
docker-compose down
```

Para reconstruir as imagens:
```bash
docker-compose build --no-cache
```

Para subir e reconstruir:
```bash
docker-compose up -d --build
```

## Serviços

- **product-service**: http://localhost:8081
- **discount-service**: http://localhost:8082
- **shop-service**: http://localhost:8080

## Health Checks

Os serviços possuem health checks configurados. O shop-service aguarda os outros serviços estarem saudáveis antes de iniciar.

