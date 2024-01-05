import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EtudiantManagement etudiantManagement = new EtudiantManagement();

        List<Etudiant> le=new ArrayList<>();
        Etudiant e1=new Etudiant(10,"ghaith",22);
        Etudiant e2=new Etudiant(2,"yassine",22);
        Etudiant e3=new Etudiant(3,"malek",22);

        le.add(e1);
        le.add(e2);
        le.add(e3);

        //using displayStudents(Consumer) with a lambda expression
        System.out.println("Using Lambda Expression:");
        etudiantManagement.displayStudents(le, student -> System.out.print(student));

        // using displayStudents(Consumer) with a method reference
        System.out.println("\n\nUsing Method Reference:");
        etudiantManagement.displayStudents(le, System.out::print);


        // using displayStudentsByFilter (Consumer,Predicate) with a method reference
        Predicate<Etudiant> pre = s -> s.getId()%2==0;
        System.out.println("\n\nUsing displayStudentsByFilter Method Reference:");
        etudiantManagement.displayStudentsByFilter(le,pre,System.out::print);

        // using displayStudentsByFilter(Function) with a method reference
        Function<Etudiant, String> fun = s -> s.getNom();
        System.out.println("\n\nUsing returnStudentsNames Method Reference:");
        System.out.println(etudiantManagement.returnStudentsNames(le,fun));

        //Définition d'un “Supplier” qui renvoie une nouvelle instance de la classe Etudiant initialisée avec new Etudiant
        Supplier<Etudiant> sup = () -> new Etudiant(4,"newGhaith",20);
        System.out.println("\n\nUsing Supplier create new instance with Method Reference:");
        Etudiant e4 = etudiantManagement.createStudent(sup);
        System.out.println(e4);
        le.add(e4);
        System.out.println("\n\nMy new list :");
        etudiantManagement.displayStudents(le, System.out::print);

        //filter with id using Comparator
        Comparator<Etudiant> com=((o1, o2) -> o1.getId()- o2.getId());
        //Comparator<Etudiant> com=(Comparator.comparingInt(Etudiant::getId));
        System.out.println("\n\nMy filtred new list :");
        System.out.println(etudiantManagement.sortStudentsById(le,com));

        //Using Stream methode de reference
        System.out.println("\n\nMy Stream new list :");
        Stream<Etudiant> stream = etudiantManagement.convertToStream(le);
        le.forEach(System.out::print);
    }
}