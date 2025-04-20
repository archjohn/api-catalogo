package api.catalogo.application.category.create;

import com.api.catalogo.application.UseCase;
import com.api.catalogo.application.category.create.CreateCategoryCommand;
import com.api.catalogo.application.category.create.CreateCategoryUseCase;
import com.api.catalogo.application.category.create.DefaultCreateCategoryUseCase;
import com.api.catalogo.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class CreateCategoryUseCaseTest {
    //  1. Teste do caminho feliz
    //  2. Teste passando uma propriedade inv�lida (name)
    //  3. Teste criando uma categoria inativa
    //  4. Teste simulando um erro generico vindo do gateway

    @Test
    public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId() {
        final var expectedName = "a Name";
        final var expectedDescription = "a some Description";
        final var expectedIsActive = true;

        final var aCommand = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

        final CategoryGateway categoryGateway = Mockito.mock(CategoryGateway.class);

        Mockito.when(
            categoryGateway.create(Mockito.any())
        ).thenAnswer(returnsFirstArg());

        final var useCase = new DefaultCreateCategoryUseCase(categoryGateway);

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(categoryGateway, Mockito.times(1))
            .create(Mockito.argThat(aCategory -> {
                return Objects.equals(expectedName, aCategory.getName())
                    && Objects.equals(expectedDescription, aCategory.getDescription())
                    && Objects.equals(expectedIsActive, aCategory.isActive())
                    && Objects.nonNull(aCategory.getId())
                    && Objects.nonNull(aCategory.getCreatedAt())
                    && Objects.nonNull(aCategory.getUpdateAt())
                    && Objects.isNull(aCategory.getDeletedAt());
            }

            ));
    }
}
