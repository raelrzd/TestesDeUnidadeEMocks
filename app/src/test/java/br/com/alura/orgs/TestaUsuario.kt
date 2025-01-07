package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert
import org.junit.Test

class TestaUsuario {

    @Test
    fun retornaVerdadeiroSeOsDadosDoUsuarioEstaoCorretos() {
        val usuarioValido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioValido.ehValido()
        Assert.assertTrue(resultado)
    }

    @Test
    fun retornaFalsoSeOEmailDoUsuarioEhInvalido() {
        // Arrange - Organizar
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "emailinvalido.com",
            senha = "senhaforte123"
        )

        // Act - Agir
        val resultado = usuarioInvalido.ehValido()

        // Assert - Afirmar
        Assert.assertFalse(resultado)
    }

    @Test
    fun retornaFalsoSeASenhaDoUsuarioEhFraca() {
        // Arrange - Organizar
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "email@valido.com",
            senha = "senha"
        )

        // Act - Agir
        val resultado = usuarioInvalido.ehValido()

        // Assert - Afirmar
        Assert.assertFalse(resultado)
    }

}