import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CodeRearrangingTest.class, CommentsTest.class,
	DisimilarFilesTest.class, EmptyFilesTest.class,
	FunctionRenamingTest.class, IdentifierRenamingTest.class,
	SpecialCharsTest.class, WhiteSpaceTruncatingTest.class})
public class Sprint3TestSuite {

}
