import { useState, useEffect } from 'react';
import { FileText, Search, CreditCard, DollarSign } from 'lucide-react';
import api from '../api/axios';

export default function Invoices() {
  const [invoices, setInvoices] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchInvoices();
  }, []);

  const fetchInvoices = async () => {
    try {
      setLoading(true);
      const response = await api.get('/invoice');
      setInvoices(response.data || []);
    } catch (error) {
      console.error("Error fetching invoices:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-container">
      <div className="page-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem' }}>Invoices & Payments</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Manage billing, vendor invoices, and payment tracking.</p>
        </div>
      </div>

      <div className="glass-panel vendors-content">
        <div className="table-controls">
          <div className="search-box">
            <Search size={18} className="search-icon" />
            <input 
              type="text" 
              placeholder="Search invoices by PO or Vendor..." 
              className="input-base"
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>
        </div>

        {loading ? (
          <div className="loading-state">Loading invoices...</div>
        ) : (
          <div className="table-container">
            <table className="table">
              <thead>
                <tr>
                  <th>Invoice ID</th>
                  <th>PO Number</th>
                  <th>Issue Date</th>
                  <th>Due Date</th>
                  <th>Amount</th>
                  <th style={{ textAlign: 'right' }}>Actions</th>
                </tr>
              </thead>
              <tbody>
                {invoices.length > 0 ? invoices.map((inv) => (
                  <tr key={inv.invoiceId}>
                    <td style={{ fontWeight: 500 }}>INV-{inv.invoiceId}</td>
                    <td>PO-{inv.purchaseOrder?.poId || 'N/A'}</td>
                    <td>{new Date(inv.dateIssued).toLocaleDateString()}</td>
                    <td>{new Date(inv.dueDate).toLocaleDateString()}</td>
                    <td style={{ fontWeight: 600, color: 'var(--text-primary)' }}>
                      ${inv.totalAmount?.toFixed(2)}
                    </td>
                    <td>
                      <div className="action-buttons">
                        <button className="icon-btn" title="View Details"><FileText size={18} /></button>
                        <button className="icon-btn" style={{ color: 'var(--secondary)' }} title="Process Payment">
                          <CreditCard size={18} />
                        </button>
                      </div>
                    </td>
                  </tr>
                )) : (
                  <tr>
                    <td colSpan="6" style={{ textAlign: 'center', padding: '3rem', color: 'var(--text-secondary)' }}>
                      No invoices found.
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
