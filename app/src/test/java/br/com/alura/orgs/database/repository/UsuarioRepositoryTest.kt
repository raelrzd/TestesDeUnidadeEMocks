package br.com.alura.orgs.database.repository

import br.com.alura.orgs.database.dao.UsuarioDao
import br.com.alura.orgs.model.Usuario
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UsuarioRepositoryTest {

    @Test
    fun `deve chamar o dao quando salva um usuario`() = runTest {
        //Arrange - Config
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuario = Usuario(
            id = "usuario",
            email = "teste@usuario.com",
            senha = "testesenha"
        )

        coEvery {
            dao.salva(usuario)
        }.returns(Unit)

        //Act
        usuarioRepository.salva(usuario)

        coVerify {
            dao.salva(usuario)
        }
    }

    @Test
    fun `deve chamar o dao quando autentica um usuario`() = runTest {
        //Arrange - Config
        val dao = mockk<UsuarioDao>()
        val usuarioRepository = UsuarioRepository(dao)
        val usuarioEmail = "teste@usuario.com"
        val usuarioId = "usuario"
        val usuarioSenha = "testesenha"

        coEvery {
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

        coVerify {
            dao.autentica(usuarioId, usuarioSenha)
        }
    }
}