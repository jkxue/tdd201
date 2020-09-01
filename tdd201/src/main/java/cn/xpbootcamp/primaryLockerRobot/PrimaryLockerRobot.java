package cn.xpbootcamp.primaryLockerRobot;

import cn.xpbootcamp.locker.domain.Bag;
import cn.xpbootcamp.locker.domain.Locker;
import cn.xpbootcamp.locker.domain.Ticket;
import cn.xpbootcamp.locker.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> managedLockers;
    private HashMap<Ticket, Bag> bagMap = new HashMap<>();

    public Ticket store(Bag bagA) {
        for (Locker locker : managedLockers) {
            if (locker.getAvailableSpaceNumber() > 0) {
                return locker.store(bagA);
            }
        }
        throw new NoAvailableSpaceException("No available space");
    }

    public void setManagedLockers(List<Locker> lockers) {
        this.managedLockers = lockers;
    }

    public Bag getBag(Ticket ticketA) {
        return this.managedLockers.get(0).getBag(ticketA);
    }
}