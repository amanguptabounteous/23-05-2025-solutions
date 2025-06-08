package Steam_assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Laptop {
    String model;
    String processorModel;
    int ram;
    int graphicsCard;
    int memory;
    int hardDisk;
    LocalDate manufactureDate;

    public Laptop(String model, String processorModel, int ram, int graphicsCard, int memory, int hardDisk, LocalDate manufactureDate) {
        this.model = model;
        this.processorModel = processorModel;
        this.ram = ram;
        this.graphicsCard = graphicsCard;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString() {
        return model + " | " + processorModel + " | RAM: " + ram + "GB | GPU: " + graphicsCard + "GB | Memory: " + memory + "GB | HDD: " + hardDisk + "GB | Date: " + manufactureDate;
    }
}


public class problem4 {
    public static void main(String[] args) {
        List<Laptop> laptops = Arrays.asList(
                new Laptop("HP Pavilion", "Intel i5", 16, 4, 512, 1000, LocalDate.of(2022, 5, 1)),
                new Laptop("Dell XPS", "Intel i7", 32, 6, 1024, 2000, LocalDate.of(2023, 3, 15)),
                new Laptop("Acer Nitro", "AMD Ryzen 7", 16, 4, 512, 1000, LocalDate.of(2021, 9, 10)),
                new Laptop("Lenovo Legion", "AMD Ryzen 7", 32, 8, 1024, 2000, LocalDate.of(2023, 1, 20)),
                new Laptop("Asus ZenBook", "Intel i5", 8, 2, 256, 512, LocalDate.of(2020, 2, 5))
        );
        System.out.println("All laptops with at least 16GB RAM and 6GB VRAM");
        laptops.stream().
                filter(lap -> lap.ram >= 16 && lap.graphicsCard>=6)
                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        System.out.println("Laptops Grouped by Processor Type: ");
        Map<String, List<Laptop>> mp = laptops.stream().
                collect(Collectors.groupingBy(lap -> lap.processorModel));
        mp.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("Printing with sorted according to Memory, HDD, DOM:");
        mp.forEach((key, value) ->{
            System.out.println(key + ":");
            value.stream().sorted(Comparator.comparingInt((Laptop l)->l.memory).
                    thenComparingInt(l->l.hardDisk)
                    .thenComparing(l -> l.manufactureDate))
                    .forEach(System.out::println);
            System.out.println();
        });
    }
}