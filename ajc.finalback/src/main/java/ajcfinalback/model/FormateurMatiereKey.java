package ajcfinalback.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FormateurMatiereKey implements Serializable{

	@Column(name = "matiere_id")
	private Integer matiereId;
	
	@Column(name = "formateur_id")
	private Integer formateurId;
	
	public FormateurMatiereKey() {}
	
	public FormateurMatiereKey(Integer matiereId, Integer formateurId) {
		this.matiereId = matiereId;
		this.formateurId = formateurId;
	}
	
	public Integer getMatiereId() { return matiereId; }
	public void setMatiereId(Integer matiereId) { this.matiereId = matiereId; }
	
	public Integer getFormateurId() { return formateurId; }
	public void setFormateurId(Integer formateurId) { this.formateurId = formateurId; }
	
	@Override
	public int hashCode() { return Objects.hash(formateurId, matiereId); }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormateurMatiereKey other = (FormateurMatiereKey) obj;
		return Objects.equals(formateurId, other.formateurId) && Objects.equals(matiereId, other.matiereId);
	}
	
	
	
}
