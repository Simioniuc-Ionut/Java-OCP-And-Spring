
# Adding Beans to the Spring Boot Context

This section explains how to register beans in the Spring Boot application context. There are three common approaches:

## 1. Using the `@Bean` Annotation
- Define a method annotated with `@Bean` inside a `@Configuration` class.
- The method’s return value is added to the Spring context as a bean.
- **Key point:** This approach allows multiple beans of the same type by giving them different names.

## 2. Using Stereotype Annotations (e.g., `@Component`)
- Annotate a class with `@Component` (or other stereotypes like `@Service`, `@Repository`).
- Spring automatically detects and registers the class as a bean during component scanning.
- **Key point:** Typically, only one bean of a given type is registered this way.

## 3. Programmatic Registration
- Starting with Spring 5, you can register beans at runtime using the `registerBean()` method.
- This approach is useful for dynamic or conditional bean creation.
