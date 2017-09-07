package org.ostroukh.dionisus.app.model.search.criteria.range;

import org.ostroukh.dionisus.app.infra.util.Checks;

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
     * Number of elements per page. Zero means that we should return all the
     * elements
     */
    private final int rowCount;

    public RangeCriteria(int page, int rowCount) {
        Checks.checkParameter(page > 0, "Index \"" + page + "\" is incorrect");
        Checks.checkParameter(rowCount > 0, "Row count \"" + page + "\" is incorrect");

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
