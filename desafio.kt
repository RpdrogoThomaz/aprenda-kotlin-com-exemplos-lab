// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Level { BASIC, INTERMEDIATE, ADVANCED }

data class Student(val name:String) 

data class SchoolSubjects(var name: String, val level: Level, val duration: Int = 60)

data class Formation(val name: String, var schoolSubjects: List<SchoolSubjects>) {

  val enrolledStudents = mutableListOf<Pair<Student, Formation>>()
    // Aqui estamos uma classe interna, que é responsável pela matricula 
    inner class enroll(vararg students: Student) {
        // aqui temos um bloco init que é iniciado no momento em que instanciamos a class enroll, dentro do bloco adicionamos a lista de enrroledStudents em pares onde temos aluinos e formação.
      init{
        enrolledStudents.addAll(students.map{it to this@Formation})
        }
    }
}

fun main() {
    // aqui estamos instanciando a class SchoolSubjects 2x 
    val kotlinBasic = SchoolSubjects("Kotlin Basic", Level.BASIC)
    val kotlinAdvanced = SchoolSubjects("Kotlin Advanced", Level.ADVANCED)

    // aqui uma instânncia da class Formation
    val kotlinFormation = Formation("Kotlin Formation", listOf(kotlinBasic, kotlinAdvanced))

    // Aqui duas instancia da class Student
    val student1 = Student("Rodrigo")
    val student2 = Student("Vania")

    // aqui estamos realizando a matricula do aluno1 e 2 na formação kotlin
    kotlinFormation.enroll(student1, student2)

    // aqui o for repete enquanto triver alunos matriculados na formação kotlin, e aí faz a impressão do nome da formação e da disciplina
     for ((student, formation) in kotlinFormation.enrolledStudents) {
        println("${student.name} - Formation: ${formation.name}")
        println("School Subjects:")
        for (subject in formation.schoolSubjects) {
            println("  - ${subject.name}")
        }
        println()
    }
}
