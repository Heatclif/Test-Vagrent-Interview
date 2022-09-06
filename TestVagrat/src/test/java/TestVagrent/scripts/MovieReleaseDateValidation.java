package TestVagrent.scripts;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MovieReleaseDateValidation
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MovieReleaseDateValidation(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MovieReleaseDateValidation.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
