package edu.gtu.SoftwareStoreManager;


/**
 * Software class that represents software properties.
 */
public class Software implements Comparable<Software> {

    private String labelName;
    private String name;
    private String version;
    private Integer quantity;
    private Double price;

    /**
     * Initialize a software with some properties.
     * @param name pure name of the product.
     * @param version version of the product.
     * @param quantity quantity of the product.
     * @param price price of the product.
     */
    public Software( String name , String version , Integer quantity ,
              Double price) {

        this.name = name;
        this.version = version;
        labelName = name + " " + version;

        this.quantity = quantity;
        this.price = price;

    }


    /**
     * Return the name of the product.
     * @return pure name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the price of the product.
     * @return price of the product.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Return the quantity of the product.
     * @return quantity of the product.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Return the version of the product.
     * @return the version code of the product.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Return the label-tag of the product.
     * @return label-tag of current product.
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * Set the pure name of the product.
     * @param name pure name.
     */
    public void setName(String name) {
        this.name = name;
        labelName = name + " " + version;
    }

    /**
     * Set the price of the software.
     * @param price price of the software.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Set the quantity of the product.
     * @param quantity quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Set the version of the product.
     * @param version version of the software.
     */
    public void setVersion(String version) {
        this.version = version;
        labelName = name + " " + version;
    }

    /**
     * Label-tag name of the product.
     * @param labelName label-tag of the product.
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * Increase quantity with given value.
     * @param i value that will be add.
     */
    public void increaseQuantity(int i ) {
        quantity += i;
        setQuantity( quantity );
    }

    /**
     * Increase quantity with given value.
     * @param i value that will be add.
     */
    public void decreaseQuantity( int i ) {
        quantity -= i;
        setQuantity( quantity );
    }

    /**
     * Equals method for software product. It jsut check the
     * label name of the product.
     * @param obj Obejct reference of the product.
     * @return true if they equals otherwise return false.
     */
    @Override
    public boolean equals(Object obj) {

        if( obj == this ) {
            return true;
        }

        if( !(obj instanceof Software) ) {
            return false;
        }

        return ((Software)obj).getLabelName().equals( getLabelName() );
    }


    /**
     * Hash-Code of the product.
     * @return hash-code.
     */
    @Override
    public int hashCode() {
        return getLabelName().hashCode() * 37;
    }


    /**
     * String representation if the product.
     * @return String representation of the product.
     */
    @Override
    public String toString() {

        return "----------------\n" + "Name : " + getLabelName() + "\n" +
                "Quantity : " + getQuantity() + "\n" +
                "Price : " + getPrice() + " TL" + "\n" + "\n";
    }

    @Override
    public int compareTo(Software software) {
        return software.getLabelName().compareTo( this.getLabelName() );
    }
}
