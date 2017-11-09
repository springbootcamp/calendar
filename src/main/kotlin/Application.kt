package org.springbootcamp.calendar

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class CalendarApplication

fun main(args: Array<String>) {
  SpringApplication.run(CalendarApplication::class.java, *args)
}
