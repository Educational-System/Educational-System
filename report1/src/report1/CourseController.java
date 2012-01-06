/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    
    public void deleteSupervisor(Supervisor S)
    {
        int Temp = supervisors.indexOf(S);
        if (Temp<0)
            return;
        Semester currentSemester = new Semester(supervisors.get(Temp).getSemester().getSemesterNumber(), new Date().getYear()+1900, new Date());
        if (supervisors.get(Temp).getSemester().compareTo(currentSemester)<0)
            return;
        else
        {
            for (Enrollment E : enrollments)
                if ((E.getCourse().equals(S.getCourse())) && E.getSemester().equals(currentSemester))
                    return;
            supervisors.remove(Temp);
        }
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
    
// <editor-fold desc="Binary File Writers">
    
    public void writeAcademicsBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (AcademicStaff A : academics)
            A.binaryFileWrite(writer);
        writer.close();
    }
    
    public void writeCoursesBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (Course C : courses)
            C.binaryFileWrite(writer);
        writer.close();
    }
    
    public void writeEnrollmentsBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (Enrollment E : enrollments)
            E.binaryFileWrite(writer);
        writer.close();
    }
    
    public void writeSemestersBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (Semester S : semesters)
            S.binaryFileWrite(writer);
        writer.close();
    }
    
    public void writeStudentsBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (Student S : students)
            S.binaryFileWrite(writer);
        writer.close();
    }
    
    public void writeSupervisorsBinary(String FilePath) throws FileNotFoundException, IOException
    {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(FilePath));
        for (Supervisor S : supervisors)
            S.binaryFileWrite(writer);
        writer.close();
    }
    
// </editor-fold>
    
// <editor-fold desc="Binary File Readers">
    
    public void readAcademicsBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                AcademicStaff Temp = AcademicStaff.binaryFileRead(reader);
                academics.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readCoursesBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                Course Temp = Course.binaryFileRead(reader);
                courses.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readEnrollmentsBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                Enrollment Temp = Enrollment.binaryFileRead(reader);
                enrollments.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSemestersBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                Semester Temp = Semester.binaryFileRead(reader);
                semesters.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readStudentsBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                Student Temp = Student.binaryFileRead(reader);
                students.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSupervisorsBinary(String FilePath) throws IOException
    {
        DataInputStream reader = new DataInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
            {
                Supervisor Temp = Supervisor.binaryFileRead(reader);
                supervisors.add(Temp);
            }
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
// </editor-fold>
    
// <editor-fold desc="Serialized Writers">
    
    public void writeAcademicsSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (AcademicStaff A : academics)
            writer.writeObject(A);
        writer.close();
    }
    
    public void writeCoursesSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (Course C : courses)
            writer.writeObject(C);
        writer.close();
    }
    
    public void writeEnrollmentsSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (Enrollment E : enrollments)
            writer.writeObject(E);
        writer.close();
    }
    
    public void writeSemestersSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (Semester S : semesters)
            writer.writeObject(S);
        writer.close();
    }
    
    public void writeStudentsSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (Student S : students)
            writer.writeObject(S);
        writer.close();
    }
    
    public void writeSupervisorsSerialized(String FilePath) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(FilePath));
        for (Supervisor S : supervisors)
            writer.writeObject(S);
        writer.close();
    }
    
// </editor-fold>
    
// <editor-fold desc="Serialized Readers">
    
    public void readAcademicsSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                academics.add((AcademicStaff)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readCoursesSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                courses.add((Course)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readEnrollmentsSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                enrollments.add((Enrollment)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSemestersSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                semesters.add((Semester)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readStudentsSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                students.add((Student)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
    public void readSupervisorsSerialized(String FilePath) throws IOException, ClassNotFoundException
    {
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(FilePath));
        try
        {
            while (true)
                supervisors.add((Supervisor)reader.readObject());
        }
        catch(IOException E)
        {
            reader.close();
        }
    }
    
// </editor-fold>
    
// <editor-fold desc="Sorting">
    
    public void sortAcademics()
    {
        Collections.sort(academics);
    }
    
    public void sortStudents()
    {
        Collections.sort(students);
    }
    
    public void sortEnrollments()
    {
        Collections.sort(enrollments);
    }
    
    public void sortSemesters()
    {
        Collections.sort(semesters);
    }
    
// </editor-fold>
    
// <editor-fold desc="Statistics">
    
    public PassReport courseStatistics(Course C)
    {
        int pass = 0, fail=0;
        for (Enrollment E : enrollments)
            if (E.getCourse().equals(C))
            {
                if (E.getMark()>-1 && E.getMark()<60)
                    fail++;
                else
                    pass++;
            }
        return new PassReport(pass, fail);
    }
    
    public PassReport courseStatistics(Semester S)
    {
        int pass = 0, fail=0;
        for (Enrollment E : enrollments)
            if (E.getSemester().equals(S))
            {
                if (E.getMark()>-1 && E.getMark()<60)
                    fail++;
                else
                    pass++;
            }
        return new PassReport(pass, fail);
    }
    
    public PassReport courseStatistics()
    {
        int pass = 0, fail = 0;
        for (Enrollment E : enrollments)
            if (E.getMark()>-1 && E.getMark()<60)
                fail++;
            else
                pass++;
        return new PassReport(pass, fail);
    }
    
    public double studentStatistics(Long S, Semester M)
    {
        double accumulator = 0;
        int count = 0;
        for (Enrollment E : enrollments)
        {
            if ((E.getSemester().equals(M)) && (E.getStudent().getStudentNumber()==S))
            {
                accumulator+=E.getMark();
                count++;
            }
        }
        return accumulator/count;
    }
    
// </editor-fold>
    
}
