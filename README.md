# KMP Notes

Este proyecto es una aplicación de notas que permite añadir, consultar y filtrar notas en diferentes plataformas: Android, Web y Desktop (macOS, Windows, Linux). Utiliza Kotlin Multiplatform para el código compartido y Ktor para la comunicación con el servidor backend.

## Estructura del Proyecto

- **commonMain**: Código compartido entre todas las plataformas.
  - `kotlin/org/example/project/`
    - `data`: Modelos de datos.
    - `ui`: Interfaz para las distintas pantallas

- **androidMain**: Módulo para la aplicación Android.
- **desktopMain**: Módulo para aplicaciones de escritorio.
- **wasmJsMain**: Módulo para la aplicación web.

## Pre-requisitos

- JDK 11 o superior
- [Kotlin Multiplatform Mobile plugin](https://kotlinlang.org/docs/mobile/setup.html) para Android Studio

## Configuración

### Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd notas-multiplataforma
