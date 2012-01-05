/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class CourseController {
    
// <editor-fold desc="Private Data Members">
    
    private ArrayList<AcademicStaff> academics;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;
    private ArrayList<Semester> semesters;
    private ArrayList<Student> students;
    private ArrayList<Supervisor> supervisors;
        
// </editor-fold>
    
// <editor-fold desc="Constructors">
    
    public CourseController()
    {
        academics = new ArrayList<AcademicStaff>();
        courses = new ArrayList<Course>();
        enrollments = new ArrayList<Enrollment>();
        semesters = new ArrayList<Semester>();
        students = new ArrayList<Student>();
        supervisors = new ArrayList<Supervisor>();
    }
    
// </editor-fold>
    
// <editor-fold desc="Adders">
    
    public void addAcademicStaff(AcademicStaff A)
    {
        academics.add(A);
    }
    
    public void addCourse(Course C)
    {
        courses.add(C);
    }
    
    public void addEnrollment(Enrollment E)
    {
        enrollments.add(E);
    }
    
    public void addSemester(Semester S)
    {
        semesters.add(S);
    }
    
    public void addStudent(Student S)
    {
        students.add(S);
    }
    
    public void addSupervisor(Supervisor S)
    {
        supervisors.add(S);
    }
    
// </editor-fold>
    
// <editor-fold desc="Modifiers">
    
    public void modifyAcademicStaff(AcademicStaff A, AcademicStaff New)
    {
        int temp = academics.indexOf(A);
        if (temp<0)
            return;
        academics.get(temp).setAcademicDegreee(New.getAcademicDegreee());
        academics.get(temp).setDegreeDate(New.getDegreeDate());
        academics.get(temp).setFirstName(New.getFirstName());
        academics.get(temp).setLastName(New.getLastName());
        academics.get(temp).setNSN(New.getNSN());
    }
    
    public void modifyCourse(Course C, Course New)
    {
        int temp = courses.indexOf(C);
        if (temp<0)
            return;
        courses.get(temp).setCourseName(New.getCourseName());
    }
    
    public void modifyEnrollment(Enrollment E, Enrollment New)
    {
        if (E.getSemester().getEndDate().compareTo(new Date())>=0)
            return;
        int Temp = enrollments.indexOf(E);
        if (Temp<0)
            return;
        enrollments.get(Temp).setCourse(New.getCourse());
        enrollments.get(Temp).setMark(New.getMark());
        enrollments.get(Temp).setSemester(New.getSemester());
        enrollments.get(Temp).setStudent(New.getStudent());
    }
    
    public void modifyStudent(Student S, Student New)
    {
        int Temp = students.indexOf(S);
        if (Temp<0)
            return;
        students.get(Temp).setFirstName(New.getFirstName());
        students.get(Temp).setLastName(New.getLastName());
        students.get(Temp).setNSN(New.getNSN());
    }
    
    public void modifySupervisor(Supervisor S, Supervisor New)
    {
        int Temp = supervisors.indexOf(S);
        if (Temp<0)
            return;
        supervisors.get(Temp).setAcademicStaff(New.getAcademicStaff());
        supervisors.get(Temp).setCourse(New.getCourse());
        supervisors.get(Temp).setSemester(New.getSemester());
    }
    
// </editor-fold>
    
// <editor-fold desc="Deleters">
    
    public void deleteAcademicStaff(AcademicStaff A)
    {
        int temp = academics.indexOf(A);
        if (temp<0)
            return;
        for (Supervisor S : supervisors)
            if (S.getAcademicStaff().equals(A))
                return;
        academics.remove(temp);
    }
    
    public void deleteCourse(Course C, Course New)
    {
        int temp = courses.indexOf(C);
        if (temp<0)
            return;
        courses.get(temp).setCourseName(New.getCourseName());
    }
    
    public void deleteStudent(Student S)
    {
        int Temp = students.indexOf(S);
        if (Temp<0)
            return;
        for (Enrollment E : enrollments)
            if ((E.getStudent().equals(students.get(Temp))) && E.getMark()>-1)
                return;
        students.remove(Temp);
    }
    
    public void deleteSupervisor(Supervisor S, Supervisor New)
    {
        int Temp = supervisors.indexOf(S);
        if (Temp<0)
            return;
        Semester currentSemester = new Semester(supervisors.get(Temp).getSemester().getSemesterNumber(), new Date().getYear()+1900, new Date());
        if (supervisors.get(Temp).getSemester().compareTo(currentSemester)<0)
            return;
        else
            supervisors.remove(Temp);
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File Writers">
    
    public void writeAcademicsText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (AcademicStaff A : academics)
            A.textFileWrite(writer);
        writer.close();
    }
    
    public void writeCoursesText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (Course C : courses)
            C.textFileWrite(writer);
        writer.close();
    }
    
    public void writeEnrollmentsText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (Enrollment E : enrollments)
            E.textFileWrite(writer);
        writer.close();
    }
    
    public void writeSemestersText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (Semester S : semesters)
            S.textFileWrite(writer);
        writer.close();
    }
    
    public void writeStudentsText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (Student S : students)
            S.textFileWrite(writer);
        writer.close();
    }
    
    public void writeSupervisorsText(String FilePath) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(FilePath);
        for (Supervisor S : supervisors)
            S.textFileWrite(writer);
        writer.close();
    }
    
// </editor-fold>
    
// <editor-fold desc="Text File Readers">
    
    public void readAcademicsText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                AcademicStaff Temp = AcademicStaff.textFileRead(reader);
                academics.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readCoursesText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                Course Temp = Course.textFileRead(reader);
                courses.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readEnrollmentsText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                Enrollment Temp = Enrollment.textFileRead(reader);
                enrollments.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSemestersText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                Semester Temp = Semester.textFileRead(reader);
                semesters.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readStudentsText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                Student Temp = Student.textFileRead(reader);
                students.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSupervisorsText(String FilePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(FilePath));
        try
        {
            while (true)
            {
                Supervisor Temp = Supervisor.textFileRead(reader);
                supervisors.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
// </editor-fold>
    
}
