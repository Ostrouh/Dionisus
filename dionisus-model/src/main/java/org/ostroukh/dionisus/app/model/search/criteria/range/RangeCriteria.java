package org.ostroukh.dionisus.app.model.search.criteria.range;

import org.ostroukh.dionisus.app.infra.exeption.flow.InvalidParemeterException;

/**
 * Pagination parameters
 * @author Eugene Ostroukh
 */
public class RangeCriteria {
    /**
     *Page index (0-based)
     */
    private final int page;

    /**
     * Number of elements per page
     */
    private final int rowCount;

    public RangeCriteria(int page, int rowCount) {
        if(page < 0){
            throw new InvalidParemeterException("Index \"" + page + "\" is incorrect");
        }
        if(rowCount < 0){
            throw new InvalidParemeterException("Row count \"" + page + "\" is incorrect");
        }
        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
