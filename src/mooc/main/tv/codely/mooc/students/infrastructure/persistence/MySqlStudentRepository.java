package tv.codely.mooc.students.infrastructure.persistence;

import java.util.Optional;

import org.hibernate.SessionFactory;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

@Service
public final class MySqlStudentRepository extends HibernateRepository<Student> implements StudentRepository {

    public MySqlStudentRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Student.class);
    }

    @Override
    public void save(Student student) {
        persist(student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return byId(id);
    }
}