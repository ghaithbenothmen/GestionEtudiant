import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EtudiantManagement implements Management{



    @Override
    public void displayStudents(List<Etudiant> students, Consumer<Etudiant> con) {
       students.forEach((st)->{
           con.accept(st);
           System.out.println(",");
       });
    }

    @Override
    public void displayStudentsByFilter(List<Etudiant> students, Predicate<Etudiant> pre, Consumer<Etudiant> con) {

        students.forEach((st)->{
            if(pre.test(st)) {
                con.accept(st);
                System.out.println(",");
            }
    });

    }

    @Override
    public String returnStudentsNames(List<Etudiant> students, Function<Etudiant, String> fun) {
        StringBuilder nomList=new StringBuilder();
        students.forEach((st)->{
         String e= fun.apply(st);
            nomList.append(e).append(" ,");
        });
        return nomList.toString();
    }

    @Override
    public Etudiant createStudent(Supplier<Etudiant> sup) {
        Etudiant e=sup.get();
        return e;
    }

    @Override
    public List<Etudiant> sortStudentsById(List<Etudiant> students, Comparator<Etudiant> com) {
        Collections.sort(students,com);
        return students;

    }

    @Override
    public Stream<Etudiant> convertToStream(List<Etudiant> students) {
        return students.stream();
    }
}
