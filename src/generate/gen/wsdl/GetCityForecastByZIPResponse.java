//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2015.09.09 时间 05:56:30 PM CST 
//


package gen.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetCityForecastByZIPResult" type="{http://ws.cdyne.com/WeatherWS/}ForecastReturn" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCityForecastByZIPResult"
})
@XmlRootElement(name = "GetCityForecastByZIPResponse")
public class GetCityForecastByZIPResponse {

    @XmlElement(name = "GetCityForecastByZIPResult")
    protected ForecastReturn getCityForecastByZIPResult;

    /**
     * 获取getCityForecastByZIPResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ForecastReturn }
     *     
     */
    public ForecastReturn getGetCityForecastByZIPResult() {
        return getCityForecastByZIPResult;
    }

    /**
     * 设置getCityForecastByZIPResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastReturn }
     *     
     */
    public void setGetCityForecastByZIPResult(ForecastReturn value) {
        this.getCityForecastByZIPResult = value;
    }

}
