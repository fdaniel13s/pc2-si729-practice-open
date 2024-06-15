package biz.hotel.platform.u20221c628.shared.infrastructure.documentation.openapi.configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI learningPlatformOpenApi(){
        //General Configuration
        var openApi = new OpenAPI();

        openApi.info(new Info()
                .title("")
                .description("")
                .version("1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))

                .externalDocs(new ExternalDocumentation()
                        .description(" ... Documentation")
                        .url("https://acme-learning-center-platform.wiki.github.io/docs"));
        return openApi;
    }
}
