package ru.dbzukunft.predictor.server.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
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
        name = "DailyRate",
        propOrder = {"date", "baseCurrencyLit", "exchangeRate"}
)
@Entity
public class DailyRate implements Equals2, HashCode2 {
    @XmlElement(
            required = true
    )
    @Id
    protected String date;

    @XmlElement(
            required = true
    )
    protected String baseCurrencyLit;

    @Column
    @ElementCollection(targetClass=ExchangeRate.class)
    protected List<ExchangeRate> exchangeRate;

    public DailyRate() {
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getBaseCurrencyLit() {
        return this.baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String value) {
        this.baseCurrencyLit = value;
    }

    public List<ExchangeRate> getExchangeRate() {
        if (this.exchangeRate == null) {
            this.exchangeRate = new ArrayList();
        }

        return this.exchangeRate;
    }

    public void setExchangeRate(List<ExchangeRate> value) {
        this.exchangeRate = null;
        if (value != null) {
            List<ExchangeRate> draftl = this.getExchangeRate();
            draftl.addAll(value);
        }

    }

    public DailyRate withDate(String value) {
        this.setDate(value);
        return this;
    }

    public DailyRate withBaseCurrencyLit(String value) {
        this.setBaseCurrencyLit(value);
        return this;
    }

    public DailyRate withExchangeRate(ExchangeRate... values) {
        if (values != null) {
            ExchangeRate[] var2 = values;
            int var3 = values.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                ExchangeRate value = var2[var4];
                this.getExchangeRate().add(value);
            }
        }

        return this;
    }

    public DailyRate withExchangeRate(Collection<ExchangeRate> values) {
        if (values != null) {
            this.getExchangeRate().addAll(values);
        }

        return this;
    }

    public DailyRate withExchangeRate(List<ExchangeRate> value) {
        this.setExchangeRate(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if (object != null && this.getClass() == object.getClass()) {
            if (this == object) {
                return true;
            } else {
                DailyRate that = (DailyRate)object;
                String lhsBaseCurrencyLit = this.getDate();
                String rhsBaseCurrencyLit = that.getDate();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "date", lhsBaseCurrencyLit), LocatorUtils.property(thatLocator, "date", rhsBaseCurrencyLit), lhsBaseCurrencyLit, rhsBaseCurrencyLit, this.date != null, that.date != null)) {
                    return false;
                } else {
                    lhsBaseCurrencyLit = this.getBaseCurrencyLit();
                    rhsBaseCurrencyLit = that.getBaseCurrencyLit();
                    if (!strategy.equals(LocatorUtils.property(thisLocator, "baseCurrencyLit", lhsBaseCurrencyLit), LocatorUtils.property(thatLocator, "baseCurrencyLit", rhsBaseCurrencyLit), lhsBaseCurrencyLit, rhsBaseCurrencyLit, this.baseCurrencyLit != null, that.baseCurrencyLit != null)) {
                        return false;
                    } else {
                        List<ExchangeRate> lhsExchangeRate = this.exchangeRate != null && !this.exchangeRate.isEmpty() ? this.getExchangeRate() : null;
                        List<ExchangeRate> rhsExchangeRate = that.exchangeRate != null && !that.exchangeRate.isEmpty() ? that.getExchangeRate() : null;
                        return strategy.equals(LocatorUtils.property(thisLocator, "exchangeRate", lhsExchangeRate), LocatorUtils.property(thatLocator, "exchangeRate", rhsExchangeRate), lhsExchangeRate, rhsExchangeRate, this.exchangeRate != null && !this.exchangeRate.isEmpty(), that.exchangeRate != null && !that.exchangeRate.isEmpty());
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
        String theBaseCurrencyLit = this.getDate();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date", theBaseCurrencyLit), currentHashCode, theBaseCurrencyLit, this.date != null);
        theBaseCurrencyLit = this.getBaseCurrencyLit();
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "baseCurrencyLit", theBaseCurrencyLit), currentHashCode, theBaseCurrencyLit, this.baseCurrencyLit != null);
        List<ExchangeRate> theExchangeRate = this.exchangeRate != null && !this.exchangeRate.isEmpty() ? this.getExchangeRate() : null;
        currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exchangeRate", theExchangeRate), currentHashCode, theExchangeRate, this.exchangeRate != null && !this.exchangeRate.isEmpty());
        return currentHashCode;
    }

    public int hashCode() {
        HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE2;
        return this.hashCode((ObjectLocator)null, strategy);
    }
}
