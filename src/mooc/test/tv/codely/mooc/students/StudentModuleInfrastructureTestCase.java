package tv.codely.mooc.students;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

public abstract class StudentModuleInfrastructureTestCase extends InfrastructureTestCase {

    @Autowired
    protected StudentRepository repository;
}
