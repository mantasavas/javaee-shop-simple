package lt.vu.usecases.SpecializesTestingFunc;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Specializes;

@Model
@Alternative
public class MockAsynchronousService extends AsynchronousService {
}
