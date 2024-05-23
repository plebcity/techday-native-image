package nl.avisi.techdaynativeimage

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.net.URI
import java.time.LocalDate
import java.util.UUID

@SpringBootApplication
class TechdayNativeImageApplication {
    @Bean
    fun restClient(): RestClient =
            RestClient.create()
}

fun main(args: Array<String>) {
    runApplication<TechdayNativeImageApplication>(*args)
}

@RestController
@RequestMapping("hello")
class HelloController {
    @GetMapping
    fun hello(): String {
        return "Hello world"
    }
}

@RestController
@RequestMapping("customer")
class CustomerController(
        private val customerRepository: CustomerRepository
) {
    @GetMapping
    fun customers(): List<Customer> =
            customerRepository.findAll().toList()
}

@Repository
interface CustomerRepository: CrudRepository<Customer, UUID>

@Entity
data class Customer(
        @Id
        val id: UUID = UUID.randomUUID(),
        @Column
        val name: String,
        @Column
        val age: Int
)

@RestController
@RequestMapping("product")
class ProductController(
        private val restClient: RestClient
) {
    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String): Product =
        restClient.get().uri(URI.create("http://localhost:8090/product/$id")).retrieve().body<Product>()!!

    @GetMapping
    fun getProducts(): List<Product> =
        restClient.get().uri(URI.create("http://localhost:8090/product")).retrieve().body<List<Product>>()!!

}

data class Product(
        val id: Int,
        val naam: String,
        val omschrijving: String,
        val tht: LocalDate?,
        val barcode: String,
        val gewicht: String?,
        val inhoud: String?,
        val statiegeld: Boolean,
        val boven18: Boolean
        )