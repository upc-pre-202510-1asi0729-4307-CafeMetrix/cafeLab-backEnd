package com.cafemetrix.cafelab.preparation.domain.model.aggregates;

import com.cafemetrix.cafelab.preparation.domain.model.commands.CreateRecipeCommand;
import com.cafemetrix.cafelab.preparation.domain.model.valueobjects.*;
import com.cafemetrix.cafelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Recipe Aggregate Root
 */
@Entity
public class Recipe extends AuditableAbstractAggregateRoot<Recipe> {
    
    /**
     * -- GETTER --
     * ID del usuario que creó la receta
     */
    @Getter
    @Column(nullable = false)
    private Long userId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "name", length = 20))
    private RecipeName name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "extraction_method", nullable = false)
    private ExtractionMethod extractionMethod;

    @Column(name = "ratio", length = 10, nullable = false)
    private String ratio;

    /**
     * -- GETTER --
     * ID de la sesión de catación asociada
     */
    @Getter
    @Column(name = "cupping_session_id")
    private Long cuppingSessionId;

    /**
     * -- GETTER --
     * ID del portafolio al que pertenece
     */
    @Getter
    @Column(name = "portfolio_id")
    private Long portfolioId;

    /**
     * -- GETTER --
     * Tiempo de preparación en minutos
     */
    @Getter
    @Column(name = "preparation_time", nullable = false)
    private Integer preparationTime;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String steps;

    @Column(columnDefinition = "TEXT")
    private String tips;

    @Column(length = 20, nullable = false)
    private String cupping;

    @Column(name = "grind_size", length = 20, nullable = false)
    private String grindSize;

    /**
     * Constructor por defecto
     */
    public Recipe() {}

    /**
     * Constructor principal
     */
    public Recipe(Long userId, String name, String imageUrl, String extractionMethod, 
                 String ratio, Long cuppingSessionId, Long portfolioId, Integer preparationTime,
                 String steps, String tips, String cupping, String grindSize) {
        this.userId = userId;
        this.name = new RecipeName(name);
        this.imageUrl = imageUrl;
        this.extractionMethod = ExtractionMethod.fromString(extractionMethod);
        this.ratio = ratio;
        this.cuppingSessionId = cuppingSessionId;
        this.portfolioId = portfolioId;
        this.preparationTime = preparationTime;
        this.steps = steps;
        this.tips = tips;
        this.cupping = cupping;
        this.grindSize = grindSize;
    }

    /**
     * Constructor con comando
     */
    public Recipe(CreateRecipeCommand command) {
        this.userId = command.userId();
        this.name = new RecipeName(command.name());
        this.imageUrl = command.imageUrl();
        this.extractionMethod = ExtractionMethod.fromString(command.extractionMethod());
        this.ratio = command.ratio();
        this.cuppingSessionId = command.cuppingSessionId();
        this.portfolioId = command.portfolioId();
        this.preparationTime = command.preparationTime();
        this.steps = command.steps();
        this.tips = command.tips();
        this.cupping = command.cupping();
        this.grindSize = command.grindSize();
    }

    /**
     * Nombre de la receta
     */
    public String getName() {
        return name.value();
    }

    /**
     * URL de la imagen de la receta
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Método de extracción utilizado
     */
    public ExtractionMethod getExtractionMethod() {
        return extractionMethod;
    }

    /**
     * Ratio de café/agua utilizado
     */
    public String getRatio() {
        return ratio;
    }

    /**
     * Pasos de preparación
     */
    public String getSteps() {
        return steps;
    }

    /**
     * Consejos adicionales
     */
    public String getTips() {
        return tips;
    }

    /**
     * Resultado de la catación
     */
    public String getCupping() {
        return cupping;
    }

    /**
     * Tamaño de molienda
     */
    public String getGrindSize() {
        return grindSize;
    }
} 