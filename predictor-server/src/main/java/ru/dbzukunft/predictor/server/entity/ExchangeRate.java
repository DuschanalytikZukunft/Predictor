package ru.dbzukunft.predictor.server.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.jvnet.jaxb2_commons.lang.*;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "ExchangeRate",
        propOrder = {"baseCurrency", "currency", "saleRateNB", "purchaseRateNB", "saleRate", "purchaseRate"}
)
@Entity
public class ExchangeRate implements Equals2, HashCode2 {

    @XmlElement(
            required = true
    )

    protected String baseCurrency;

    @Id
    protected String currency;

    protected double saleRateNB;
    protected double purchaseRateNB;
    protected double saleRate;
    protected double purchaseRate;

    public ExchangeRate() {
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public void setBaseCurrency(String value) {
        this.baseCurrency = value;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String value) {
        if (value.isEmpty()) {
            this.currency = "DEF";
        }
        this.currency = value;
    }

    public double getSaleRateNB() {
        return this.saleRateNB;
    }

    public void setSaleRateNB(double value) {
        this.saleRateNB = value;
    }

    public double getPurchaseRateNB() {
        return this.purchaseRateNB;
    }

    public void setPurchaseRateNB(double value) {
        this.purchaseRateNB = value;
    }

    public double getSaleRate() {
        return this.saleRate;
    }

    public void setSaleRate(double value) {
        this.saleRate = value;
    }

    public double getPurchaseRate() {
        return this.purchaseRate;
    }

    public void setPurchaseRate(double value) {
        this.purchaseRate = value;
    }

    public ExchangeRate withBaseCurrency(String value) {
        this.setBaseCurrency(value);
        return this;
    }

    public ExchangeRate withCurrency(String value) {
        this.setCurrency(value);
        return this;
    }

    public ExchangeRate withSaleRateNB(double value) {
        this.setSaleRateNB(value);
        return this;
    }

    public ExchangeRate withPurchaseRateNB(double value) {
        this.setPurchaseRateNB(value);
        return this;
    }

    public ExchangeRate withSaleRate(double value) {
        this.setSaleRate(value);
        return this;
    }

    public ExchangeRate withPurchaseRate(double value) {
        this.setPurchaseRate(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if (object != null && this.getClass() == object.getClass()) {
            if (this == object) {
                return true;
            } else {
                ExchangeRate that = (ExchangeRate)object;
                String lhsCurrency = this.getBaseCurrency();
                String rhsCurrency = that.getBaseCurrency();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "baseCurrency", lhsCurrency), LocatorUtils.property(thatLocator, "baseCurrency", rhsCurrency), lhsCurrency, rhsCurrency, this.baseCurrency != null, that.baseCurrency != null)) {
                    return false;
                } else {
                    lhsCurrency = this.getCurrency();
                    rhsCurrency = that.getCurrency();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "currency", lhsCurrency), LocatorUtils.property(thatLocator, "currency", rhsCurrency), lhsCurrency, rhsCurrency, this.currency != null, that.currency != null)) {
                        return false;
                    } else {
                        double lhsPurchaseRate = this.getSaleRateNB();
                        double rhsPurchaseRate = that.getSaleRateNB();
                        if (!strategy.equals(LocatorUtils.property(thisLocator, "saleRateNB", lhsPurchaseRate), LocatorUtils.property(thatLocator, "saleRateNB", rhsPurchaseRate), lhsPurchaseRate, rhsPurchaseRate, true, true)) {
                            return false;
                        } else {
                            lhsPurchaseRate = this.getPurchaseRateNB();
                            rhsPurchaseRate = that.getPurchaseRateNB();
                            if (!strategy.equals(LocatorUtils.property(thisLocator, "purchaseRateNB", lhsPurchaseRate), LocatorUtils.property(thatLocator, "purchaseRateNB", rhsPurchaseRate), lhsPurchaseRate, rhsPurchaseRate, true, true)) {
                                return false;
                            } else {
                                lhsPurchaseRate = this.getSaleRate();
                                rhsPurchaseRate = that.getSaleRate();
                                if (!strategy.equals(LocatorUtils.property(thisLocator, "saleRate", lhsPurchaseRate), LocatorUtils.property(thatLocator, "saleRate", rhsPurchaseRate), lhsPurchaseRate, rhsPurchaseRate, true, true)) {
                                    return false;
                                } else {
                                    lhsPurchaseRate = this.getPurchaseRate();
                                    rhsPurchaseRate = that.getPurchaseRate();
                                    return strategy.equals(LocatorUtils.property(thisLocator, "purchaseRate", lhsPurchaseRate), LocatorUtils.property(thatLocator, "purchaseRate", rhsPurchaseRate), lhsPurchaseRate, rhsPurchaseRate, true, true);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return false;
        }
    }

    public boolean equals(Object object) {
        EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE2;
        return this.equals((ObjectLocator)null, (ObjectLocator)null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        String theCurrency = this.getBaseCurrency();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "baseCurrency", theCurrency), currentHashCode, theCurrency, this.baseCurrency != null);
        theCurrency = this.getCurrency();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currency", theCurrency), currentHashCode, theCurrency, this.currency != null);
        double thePurchaseRate = this.getSaleRateNB();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saleRateNB", thePurchaseRate), currentHashCode, thePurchaseRate, true);
        thePurchaseRate = this.getPurchaseRateNB();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "purchaseRateNB", thePurchaseRate), currentHashCode, thePurchaseRate, true);
        thePurchaseRate = this.getSaleRate();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "saleRate", thePurchaseRate), currentHashCode, thePurchaseRate, true);
        thePurchaseRate = this.getPurchaseRate();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "purchaseRate", thePurchaseRate), currentHashCode, thePurchaseRate, true);
        return currentHashCode;
    }

    public int hashCode() {
        HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode((ObjectLocator)null, strategy);
    }
}

