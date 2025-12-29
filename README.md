# Ranking de Videojuegos

Aplicación que simula un ranking con backend en Spring Boot y frontend en Angular.

## Requisitos

- Java 21
- Maven
- Node.js 18+ (para el frontend)
- npm

## Estructura de Carpetas

### Backend (Spring Boot)
- `back-end/ranking/` - Aplicación Spring Boot
  - `src/main/java/ifc33b/dwesc/ranking/` - Código fuente Java
    - `controller` - Controladores
    - `dto` - Modelos de transferencia entre front y back
    - `model` - Modelos Java
    - `repository` - JPA
    - `service` - Lógica de negocio
    - `exception` - Control de excepciones
  - `src/main/resources/` - Recursos de la aplicación
  - `src/test/` - Tests unitarios
  - `pom.xml` - Dependencias Maven

### Frontend (Angular)
- `front-end/ranking/` - Aplicación Angular
  - `src/app/` - Código Angular
    - `components/` - Componentes reutilizables
    - `models/` - Modelos TypeScript
    - `services/` - Servicios (comunicación con backend)
  - `src/` - Assets y configuración
  - `package.json` - Dependencias npm

## Instalación

### Backend

1. Acceder a la carpeta del backend:
```bash
cd back-end/ranking
```

2. Compilar y ejecutar:
```bash
mvn spring-boot:run
```

El servidor estará disponible en `http://localhost:8080`

### Frontend

1. Acceder a la carpeta del frontend:
```bash
cd front-end/ranking
```

2. Instalar dependencias:
```bash
npm install
```

3. Ejecutar servidor de desarrollo:
```bash
npm start
```

La aplicación estará disponible en `http://localhost:4200`

## Desarrollo

### Backend

El backend está construido con:
- **Spring Boot 3.x** - Framework web
- **Spring Data JPA** - Acceso a datos
- **Maven** - Gestor de dependencias

### Frontend

El frontend está construido con:
- **Angular 18+** - Framework de desarrollo
- **TypeScript** - Lenguaje de programación
- **TailwindCSS** - Estilos
- **npm** - Gestor de dependencias

## Endpoints API

La API está disponible en `http://localhost:8080/api/candidats`

### Tabla Resumen de Endpoints

| Método | Ruta | Descripción | Status |
|--------|------|-------------|--------|
| GET | `/api/candidats` | Obtener todos los candidatos | 200 |
| POST | `/api/candidats` | Crear un nuevo candidato | 201 |
| GET | `/api/candidats/{1}/votar` | Votar a un candidato | 200 |

### 1. Obtener todos los candidatos

**GET** `/api/candidats`

Devuelve la lista de todos los candidatos

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "nom": "Final Fantasy VII",
    "vots": 1
  }
  {
    "id": 2,
    "nom": "Kingdom Hearts II",
    "vots": 1
  }
]
```

---

### 2. Crear uno nuevo candidato

**POST** `/api/candidats`

Crea un nuevo candidato.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "nom": "Final Fantasy VII",
}
```

**Parámetros requeridos:**
- `nom` (string, obligatorio): Nombre del juego

**Response (201 Created):**
```json
{
  "id": 1,
  "nom": "Final Fantasy VII",
  "vots": 1
}
```

---

### 3. Votar un candidato

**PUT** `/api/candidats/{id}/votar`

Aumenta un voto al candidato con la id introducida

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "nom": "Final Fantasy VII",
    "vots": 2
  }
]
```

---

## Ejemplos de uso

### Con cURL

**Crear un candidato:**
```bash
curl -v -X POST "http://localhost:8080/api/candidats"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"nom": "Final Fantasy VII"}'
```

**Obtener todos los candidatos**
```bash
curl -X GET "http://localhost:8080/api/candidats"
```

**Votar un cadidato**
```bash
curl -X PUT "http://localhost:8080/api/candidats/1/votar"
```

## Estructura del Proyecto

```
ranking/
├── README.md
├── back-end/
│   └── ranking/
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/ifc33b/dwesc/ranking/
│       │   │   │   ├── RankingApplication.java
│       │   │   │   ├── controller/
│       │   │   │   │   └── RankingController.java
│       │   │   │   ├── dto/
│       │   │   │   │   ├── CandidatRequest.java
│       │   │   │   │   └── CandidatResponse.java
│       │   │   │   ├── model/
│       │   │   │   │   └── Candidat.java
│       │   │   │   ├── repository/
│       │   │   │   │   └──   CandidatRepository.java
│       │   │   │   ├── service/
│       │   │   │   │   └──  RankingService.java
│       │   │   │   ├── exception/
│       │   │   │   │   ├── GlobalExceptionHandler.java
│       │   │   │   │   ├── CandidatAlreadyExistsException.java
│       │   │   │   │   └── CandidatNotFoundException.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/ifc33b/dwesc/ranking/
│       │           └── RankingApplication.java
│       └── target/ (generado por Maven)
└── front-end/
    └── ranking/
        ├── angular.json
        ├── package.json
        ├── tsconfig.json
        ├── tsconfig.app.json
        ├── tsconfig.spec.json
        ├── README.md
        ├── public/
        ├── src/
        │   ├── index.html
        │   ├── main.ts
        │   ├── styles.scss
        │   └── app/
        │       ├── app.config.ts
        │       ├── app.html
        │       ├── app.routes.ts
        │       ├── app.scss
        │       ├── app.ts
        │       ├── app.spec.ts
        │       ├── components/
        │       │   ├── formulari-candidat/
        │       │   │   ├── formulari-candidat.html
        │       │   │   ├── formulari-candidat.scss
        │       │   │   ├── formulari-candidat.ts
        │       │   │   └── formulari-candidat.spec.ts
        │       │   └── llista-candidats/
        │       │       ├── llista-candidats.html
        │       │       ├── llista-candidats.scss
        │       │       ├── llista-candidats.ts
        │       │       └── llista-candidats.spec.ts
        │       ├── models/
        │       │   ├── index.ts
        │       │   ├── candidat.model.ts
        │       │   └── candidat.model.spec.ts
        │       └── services/
        │           ├── ranking.service.ts
        │           └── ranking.service.spec.ts
```