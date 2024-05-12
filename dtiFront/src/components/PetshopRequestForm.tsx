import { useForm } from 'react-hook-form';
import './PetshopStyles.css'


interface FormData {
  data: string;
  quantidadePequenos: number;
  quantidadeGrandes: number;
}

interface PetshopFormProps {
  onSubmit: (formData: FormData) => void;
}

const PetshopForm: React.FC<PetshopFormProps> = ({ onSubmit }) => {
  const { register, handleSubmit } = useForm<FormData>();

  const onSubmitForm = (data: FormData) => {
    onSubmit(data);
  };

  return (
    <form className="petshop-form" onSubmit={handleSubmit(onSubmitForm)}>
      <label >Data:
        <input type="date" {...register("data")}/>
      </label>
      <label >
        Quantidade Cachorro Pequeno:
        <input type="number" {...register("quantidadePequenos")}/>
      </label>
      <label >
        Quantidade Cachorro Grande:
        <input type="number" {...register("quantidadeGrandes")}/>
      </label>
      <button type="submit">Buscar</button>
    </form>
  
  )
}
export default PetshopForm;