package com.example.testingmyentertainment;



import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseModelTest {

    private CourseModel courseModel;

    @Before
    public void setUp() {
        courseModel = new CourseModel("Kishore Kumar", R.drawable.kisore);
    }

    @Test
    public void testGetCourse_name() {
        assertEquals("Unexpected course name returned", "Kishore Kumar", courseModel.getCourse_name());
    }


    @Test
    public void testSetCourse_name() {
        courseModel.setCourse_name("Lata Mangeshkar");
        assertEquals("Lata Mangeshkar", courseModel.getCourse_name());
    }

    @Test
    public void testGetImgid() {
        assertEquals(R.drawable.kisore, courseModel.getImgid());
    }

    @Test
    public void testSetImgid() {
        courseModel.setImgid(R.drawable.lata);
        assertEquals(R.drawable.lata, courseModel.getImgid());
    }
}
