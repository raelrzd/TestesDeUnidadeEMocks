package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UsuarioRepositoryTest {

    @Test
    fun `deve chamar o dao quando salva um usuario`() {
        //Arrange - Config
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuario = Usuario(
            id = "usuario",
            email = "teste@usuario.com",
            senha = "testesenha"
        )

        every {
            dao.salva(usuario)
        }.returns(Unit)

        //Act
        usuarioRepository.salva(usuario)

        verify {
            dao.salva(usuario)
        }
    }

    @Test
    fun `deve chamar o dao quando autentica um usuario`() {
        //Arrange - Config
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuarioEmail = "teste@usuario.com"
        val usuarioId = "usuario"
        val usuarioSenha = "testesenha"

        every {
            dao.autentica(usuarioId, usuarioSenha)
        }.returns(
            Usuario(
                id = usuarioId,
                email = usuarioEmail,
                senha = usuarioSenha
            )
        )

        //Act
        usuarioRepository.autentica(usuarioId, usuarioSenha)

        verify {
            dao.autentica(usuarioId, usuarioSenha)
        }
    }
}