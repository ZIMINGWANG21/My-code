import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
    private ArrayList<Student> students;

    public MaxHeap(int capacity)
    {
        students = new ArrayList<Student>(capacity);
    }

    public MaxHeap(Collection<Student> collection)
    {
        students = new ArrayList<Student>(collection);
        for(int i = size()/2 - 1; i >= 0; i--)
        {
            maxHeapify(i);
        }



    }

    public Student getMax()
    {
        if(size() < 1)
        {
            throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
        }
        return students.get(0);
    }

    public Student extractMax()
    {
        Student value = getMax();
        students.set(0,students.get(size()-1));
        students.remove(size()-1);
        maxHeapify(0);
        return value;
    }

    public int size()
    {
        return students.size();
    }

    public void insert(Student elt)
    {
        //Please write me.  I should add the given student into the heap,
        //followin g the insert algorithm from the videos.

        students.add(elt);
        int index = size()-1; // get the index of newly added element
        while(index > 0 && students.get(parent(index)).compareTo(students.get(index))<0) {
                swap(index,parent(index));
                index = parent(index);
        }



    }

    public void addGrade(Student elt, double gradePointsPerUnit, int units)
    {
     // write this

        for(Student student : students){
            if(student.equals(elt)){
                student.addGrade(gradePointsPerUnit,units);
                break;
            }
        }
        for(int i =size()/2-1;i>=0;i--){
            maxHeapify(i);
        }
    }

    private int parent(int index)
    {
        return (index - 1)/2;
    }

    private int left(int index)
    {
        return 2 * index + 1;
    }

    private int right(int index)
    {
        return 2 * index + 2;
    }

    private void swap(int from, int to)
    {
        Student val = students.get(from);
        students.set(from,  students.get(to));
        students.set(to,  val);
    }

    private void maxHeapify(int index)
    {
        int left = left(index);
        int right = right(index);
        int largest = index;
        if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
        {
            largest = left;
        }
        if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
        {
            largest = right;
        }
        if (largest != index)
        {
            size();
            maxHeapify(largest);
        }
    }
}