import java.util.Random;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
        System.out.println("было");
        System.out.println(Arrays.toString(array));
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
        System.out.println("стало");
        System.out.println(Arrays.toString(array));
        // Удаление повторяющихся элементов
        array = removeElements(array);
    }
    public static int[] removeElements(int[] array) {
    return Arrays.stream(array).distinct().toArray();
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) return; //завершение при нулеыой длине массива
        if (low >= high) return; //завершение при невозможности разделения
        int middle = low + (high - low); //поиск середины
        int opora = array[middle];//центральный элемент
        int i = low, j = high;
        while (i < j)//перебор элементов массива
        {
            while (array[i] < opora) i++;
            while (array[j] > opora) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }

    }
}