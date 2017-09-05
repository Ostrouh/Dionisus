package org.ostroukh.dionisus.app.model.entity.establishment;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;

/**
 * Any tables which are in specified establishment
 * @author Eugene Ostroukh
 */
public class Table extends AbstractEntity {
    /**
     * Catering establishment that contains specified table
     */
    private Establishment establishment;

    /**
     * Number of table
     */
    private int tableNumber;

    /**
     * Number of seats at the table
     */
    private int seatsCount;

    /**
     * Flag indicating that the table is reserved
     */
    private boolean isOrdered;

    public Table(Establishment establishment, int tableNumber, int seatsCount, boolean isOrdered) {
        this.establishment = establishment;
        this.tableNumber = tableNumber;
        this.seatsCount = seatsCount;
        this.isOrdered = isOrdered;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }
}
