package org.ostroukh.dionisus.app.model.entity.establishment;

import org.ostroukh.dionisus.app.model.entity.base.AbstractEntity;

import javax.persistence.*;

/**
 * Any tables which are in specified establishment
 * @author Eugene Ostroukh
 */
@Table(name = "A_TABLE")
@Entity
public class ATable extends AbstractEntity {
    /**
     * Catering establishment that contains specified table
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ESTABLISHMENT_ID")
    private Establishment establishment;

    /**
     * Number of table
     */
    @Column(name = "TABLE_NO", length = 2)
    private int tableNumber;

    /**
     * Number of seats at the table
     */
    @Column(name = "SEATS_COUNT", length = 2)
    private int seatsCount;

    /**
     * Flag indicating that the table is reserved
     */
    @Column(name = "IS_ORDERED")
    private boolean isOrdered;

    public ATable(Establishment establishment, int tableNumber, int seatsCount, boolean isOrdered) {
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
