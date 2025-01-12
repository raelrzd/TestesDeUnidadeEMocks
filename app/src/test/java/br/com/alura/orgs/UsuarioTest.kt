package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test

class UsuarioTest {

    @Test
    fun `deve retornar verdadeiro quando os dados do usuario forem validos`() {
        val usuarioValido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioValido.ehValido()
        resultado.shouldBeTrue()
    }

    @Test
    fun `deve retornar falso quando o email do usuario for invalido`() {
        // Arrange - Organizar
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "emailinvalido.com",
            senha = "senhaforte123"
        )

        // Act - Agir
        val resultado = usuarioInvalido.ehValido()

        // Assert - Afirmar
        resultado.shouldBeFalse()
    }

    @Test
    fun `deve retornar falso quando a senha do usuario for fraca`() {
        // Arrange - Organizar
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "email@valido.com",
            senha = "senha"
        )

        // Act - Agir
        val resultado = usuarioInvalido.ehValido()

        // Assert - Afirmar
        resultado.shouldBeFalse()
    }

}