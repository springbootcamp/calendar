package org.springbootcamp.calendar

import io.swagger.annotations.ApiOperation
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.function.Supplier


@SpringBootApplication
@EnableSwagger2
class CalendarApplication

fun main(args: Array<String>) = runApplication<CalendarApplication>(*args).let{ Unit }

class BeansInitializer : ApplicationContextInitializer<GenericApplicationContext> {
  override fun initialize(context: GenericApplicationContext) = beans().initialize(context)

  fun beans() = beans {

    bean() {
      Supplier<String> { "bar" }
    }

    bean() {
      Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
    }

  }
}

@RestController
class Rest(val foo : Supplier<String>) {

  @GetMapping("/hello")
  @ApiOperation(value = "hello", notes = "detailed doc...")
  fun hello() = "hello ${foo.get()}"

}

