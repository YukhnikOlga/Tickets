
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void shouldComparePrice() {
        Ticket price1 = new Ticket("Moscow", "Leningrad", 10_000, 12, 15);
        Ticket price2 = new Ticket("Moscow", "Leningrad", 8_000, 12, 15);
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(price1);
        aviaSouls.add(price2);

        int expected = 1;
        int actual = price1.compareTo(price2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 20_000, 12, 15);
        Ticket ticket2 = new Ticket("Moscow", "Leningrad", 17_000, 12, 15);
        Ticket ticket3 = new Ticket("Moscow", "Leningrad", 10_000, 12, 15);
        Ticket ticket4 = new Ticket("Moscow", "Leningrad", 8_000, 12, 15);
        Ticket ticket5 = new Ticket("Moscow", "Leningrad", 15_000, 12, 15);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket4, ticket3, ticket5, ticket2, ticket1};
        Ticket[] actual = aviaSouls.search("Moscow", "Leningrad");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 10_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Leningrad", 7_000, 12, 15);

        int actual = 1;
        int expected = timeComparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSortFlightTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 10_000, 12, 14);
        Ticket ticket2 = new Ticket("Moscow", "Leningrad", 7_000, 12, 15);
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);


        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Leningrad", timeComparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 10_000, 12, 15);
        Ticket ticket2 = new Ticket("Kazan", "Ufa", 15_000, 12, 20);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.search("Moscow", "Leningrad");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 20_000, 12, 20);
        Ticket ticket2 = new Ticket("Kazan", "Ufa", 17_000, 12, 15);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Samara", "Krasnodar");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSeveralTicket() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "Leningrad", 10_000, 12, 15);
        Ticket ticket2 = new Ticket("Moscow", "Leningrad", 13_000, 13, 17);
        Ticket ticket3 = new Ticket("Moscow", "Leningrad", 17_000, 14, 20);
        Ticket ticket4 = new Ticket("Kazan", "Ufa", 8_000, 20, 23);
        Ticket ticket5 = new Ticket("Samara", "Krasnodar", 20_000, 19, 20);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.search("Moscow", "Leningrad");

        Assertions.assertArrayEquals(expected, actual);

    }
}
