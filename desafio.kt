enum class Level { BASIC, INTERMEDIATE, ADVANCED }

data class Student(val name:String) 

data class SchoolSubjects(var name: String, val level: Level, val duration: Int = 60)

data class Formation(val name: String, var schoolSubjects: List<SchoolSubjects>) {

// Cria uma lista que é mutpavel e que contem um par de informações( alunos e formação)
  val enrolledStudents = mutableListOf<Pair<Student, Formation>>()

    //aqui crio uma class interna, ela é responsável pelo controle de matricula de alunos na formação
    inner class enroll(vararg students: Student) {

    // aqui temos a criação de um bloco init que adiciona os alunos em uma lista enrolledStudents em par  sendo o primeiro aluno e o segundo a formação
      init{
        enrolledStudents.addAll(students.map{it to this@Formation})
        }
    }
}

fun main() {

// aqui estou instanciando 2x a schoolSubjectse passando para as variáveis kotlinBasic e kotlinAdvanced
    val kotlinBasic = SchoolSubjects("Kotlin Basic", Level.BASIC)
    val kotlinAdvanced = SchoolSubjects("Kotlin Advanced", Level.INTERMEDIATE)

// criando a instância de Formation sendo passado para kotlinFormation
    val kotlinFormation = Formation("Kotlin Formation", listOf(kotlinBasic, kotlinAdvanced))

// cirando duas instancias de student
    val student1 = Student("Rodrigo")
    val student2 = Student("Vania")

// Aqui matriculo os dois alunos na formação kotlin
    kotlinFormation.enroll(student1, student2)

// aqui fazendo a impressao do nome do Aluno, da formação assim  como das matérias, o for cria uma interação até que não exista mais alunos mariculados na kotlinFormation
     for ((student, formation) in kotlinFormation.enrolledStudents) {
        println("${student.name} - Formation: ${formation.name}")
        println("School Subjects:")
        for (subject in formation.schoolSubjects) {
            println("  - ${subject.name}")
        }
        println()
    }
}