import java.util.*;

class PetrolPump {
    int petrol;
    int distance;
    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {
    public static int circularTour(PetrolPump[] pumps) {
        Queue<PetrolPump> queue = new LinkedList<>();
        Collections.addAll(queue, pumps);
        int start = 0;
        int totalPetrol = 0;
        int totalDistance = 0;
        for (PetrolPump p : pumps) {
            totalPetrol += p.petrol;
            totalDistance += p.distance;
        }
        if (totalPetrol < totalDistance) return -1;
        int balance = 0;
        int index = 0;
        int i = 0;
        while (i < pumps.length * 2) {
            PetrolPump current = queue.poll();
            queue.add(current);
            balance += current.petrol - current.distance;
            if (balance < 0) {
                index = i + 1;
                balance = 0;
            }
            i++;
            if (index >= pumps.length) return -1;
        }
        return index;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };
        System.out.println(circularTour(pumps));
    }
}
