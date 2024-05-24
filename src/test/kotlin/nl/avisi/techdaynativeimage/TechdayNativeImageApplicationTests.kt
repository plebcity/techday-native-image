package nl.avisi.techdaynativeimage

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TechdayNativeImageApplicationTests {

    @LocalServerPort
    private var port = 0

    @Test
    fun contextLoads() {
    }

    @Test
    fun accessHelloRestController() {
        val result = RestClient.create().get().uri(URI.create("http://localhost:$port/hello")).retrieve().body<String>()
        assertEquals("Hello world", result)
    }

    @Test
    fun accessCustomerRestController() {
        val customers = RestClient.create().get().uri(URI.create("http://localhost:$port/customer")).retrieve().body<List<Customer>>()
        assertEquals(2, customers!!.size)
    }

    @Test
    fun accessProductRestController() {
        val products = RestClient.create().get().uri(URI.create("http://localhost:$port/product")).retrieve().body<List<Product>>()
        assertEquals(3, products!!.size)
    }

}
