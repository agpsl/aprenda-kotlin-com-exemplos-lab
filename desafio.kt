// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String) {
    override fun toString(): String {
        return nome
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "Nome: $nome com duração de $duracao minutos"
    }
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun getFormacao(): String {
        return """
				|Curso: $nome
				|Conteudos: 
				|	${getConteudos()}
				|Nível: ${getNivel()}
        """.trimMargin("|")
    }

    fun getConteudos(): String {
        return conteudos.joinToString("\n")
    }

    fun getInscritos(): String {
        return inscritos.joinToString(", ")
    }

    fun getNivel(): String {
        val nivelToString = when(nivel) {
            Nivel.BASICO -> "Básico"
            Nivel.INTERMEDIARIO -> "Intermediário"
            Nivel.DIFICIL -> "Difícil"
            else -> "Desconhecido"
        }
        return nivelToString
    }
}

fun main() {
    operator fun Int.times(str: String) = str.repeat(this)

    // Inicializa alunos
    val joao = Usuario("João")
    val jose = Usuario("José")
    val maria = Usuario("Maria")

    // Cria conteúdos e formação de Kotlin básico
    val formacaoKotlin = Formacao("Kotlin Básico",
        listOf(
            ConteudoEducacional("Variáveis no Kotlin", 120),
            ConteudoEducacional("Estruturas de controle no Kotlin", 180),
            ConteudoEducacional("Orientação a objetos no Kotlin", 240)
        ),
        Nivel.BASICO
    )

    // Cria conteúdos e formação de Java básico
    val formacaoJava = Formacao("Java Básico",
        listOf(
            ConteudoEducacional("Variáveis no Java", 120),
            ConteudoEducacional("Estruturas de controle no Java", 180),
            ConteudoEducacional("Orientação a objetos no Java", 240)
        ),
        Nivel.BASICO
    )

    // Verifica cursos
    println(formacaoKotlin.getFormacao())
    println(80 * "-")
    println(formacaoJava.getFormacao())
    println()

    // Inscreve alunos na formação
    formacaoKotlin.matricular(joao)
    formacaoKotlin.matricular(jose)
    formacaoJava.matricular(maria)

    // Verifica usuários inscritos
    println("Matriculados na formação Kotlin: ${formacaoKotlin.getInscritos()}")
    println(80 * "-")
    println("Matriculados na formação Java: ${formacaoJava.getInscritos()}")
}