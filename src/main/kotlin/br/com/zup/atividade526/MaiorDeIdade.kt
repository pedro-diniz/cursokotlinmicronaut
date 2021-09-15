package br.com.zup.atividade526

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Singleton
import java.time.LocalDate
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ MaiorDeIdadeValidator::class ])
annotation class MaiorDeIdade(
    val message: String = "é necessário ser maior de idade",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)


@Singleton
class MaiorDeIdadeValidator : ConstraintValidator<MaiorDeIdade, LocalDate> { // importar ConstraintValidator do Micronaut

    override fun isValid(
        value: LocalDate?,
        annotationMetadata: AnnotationValue<MaiorDeIdade>,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) {
            return false
        }

        return (value
            .plusYears(18)
            .isBefore(LocalDate.now()))
    }

}