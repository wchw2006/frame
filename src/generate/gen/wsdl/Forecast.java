//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2015.07.21 时间 06:10:21 PM CST 
//


package gen.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Forecast complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Forecast"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="WeatherID" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="Desciption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Temperatures" type="{http://ws.cdyne.com/WeatherWS/}temp"/&gt;
 *         &lt;element name="ProbabilityOfPrecipiation" type="{http://ws.cdyne.com/WeatherWS/}POP"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Forecast", propOrder = {
    "date",
    "weatherID",
    "desciption",
    "temperatures",
    "probabilityOfPrecipiation"
})
public class Forecast {

    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "WeatherID")
    protected short weatherID;
    @XmlElement(name = "Desciption")
    protected String desciption;
    @XmlElement(name = "Temperatures", required = true)
    protected Temp temperatures;
    @XmlElement(name = "ProbabilityOfPrecipiation", required = true)
    protected POP probabilityOfPrecipiation;

    /**
     * 获取date属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * 设置date属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * 获取weatherID属性的值。
     * 
     */
    public short getWeatherID() {
        return weatherID;
    }

    /**
     * 设置weatherID属性的值。
     * 
     */
    public void setWeatherID(short value) {
        this.weatherID = value;
    }

    /**
     * 获取desciption属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * 设置desciption属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesciption(String value) {
        this.desciption = value;
    }

    /**
     * 获取temperatures属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Temp }
     *     
     */
    public Temp getTemperatures() {
        return temperatures;
    }

    /**
     * 设置temperatures属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Temp }
     *     
     */
    public void setTemperatures(Temp value) {
        this.temperatures = value;
    }

    /**
     * 获取probabilityOfPrecipiation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link POP }
     *     
     */
    public POP getProbabilityOfPrecipiation() {
        return probabilityOfPrecipiation;
    }

    /**
     * 设置probabilityOfPrecipiation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link POP }
     *     
     */
    public void setProbabilityOfPrecipiation(POP value) {
        this.probabilityOfPrecipiation = value;
    }

}
