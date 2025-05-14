# Ci-Test-Examen

Ett Spring Boot-projekt för att hantera användare och uppgifter, inklusive tester och CI med GitHub Actions.

## Funktioner

- REST API för att skapa, hämta, uppdatera och ta bort användare
- Möjlighet att koppla uppgifter (tasks) till användare
- Integrationstester med MockMvc och TestRestTemplate
- GitHub Actions för att köra tester vid push/pull request

- ### Det kör
  
- Enhetstester (UserServiceUnitTest)
- Integrationstester (UserIntegrationTest)
- Komponenttester (UserServiceComponentTest)
