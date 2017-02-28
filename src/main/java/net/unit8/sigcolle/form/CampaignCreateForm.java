package net.unit8.sigcolle.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * キャンペーン新規作成Formクラス.
 *
 * @author Yoshitaka Honda
 */
@Data
public class CampaignCreateForm extends FormBase {
    /**
     * タイトル
     */
    @NotBlank
    @Length(max = 30)
    private String title;
    /**
     * 本文
     */
    @NotBlank
    @Length(max = 3000)
    private String statement;
    /**
     * 達成人数
     */
    @NotBlank
    @Digits(integer = 9, fraction = 0)
    @Min(1)
    @Max(999999999)
    private String goal;
}
